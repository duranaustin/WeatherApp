<?php
// $isCLI = ( php_sapi_name() == 'cli' );
// if (!$isCLI)
// {die('cannot run!');}
apache_child_terminate;
ini_set('memory_limit', '-1');

require '../vendor/autoload.php';
use GeoIp2\Database\Reader;
$reader = new Reader('/usr/share/GeoIP2/GeoLite2-City.mmdb');

$str = file_get_contents('../city.list.json');
// $strings = json_encode($str);
$cityIDs = json_decode($str, true);
fclose('../city.list.json');

// echo $cityIDs[0]['name'] . "\n";
// echo memory_get_peak_usage();

 $remote = isset($_SERVER['REMOTE_ADDR']) ? $_SERVER['REMOTE_ADDR'] : '67.161.211.132';
$record = $reader->city($remote);
$isoCode = $record->country->isoCode;
$city = $record->city->name;
echo $isoCode . "\n" . $city;

$getWeather = new getWeather("weather team slcc", $isoCode, $city, $cityIDs);

$id = $getWeather->setCityId($isoCode, $city, $cityIDs);
// echo $id."\n";
$getWeather->cityById($id);
$tr = null;
$cityIDs = null;
class getWeather{
    protected static $teamKey = "3047a788b7d827644b13600e4d46ab7b";
    protected $userAgent;
    protected $cityIDs;
    protected $isoCode;
    protected $city;
    
    public function __construct($userAgent, $isoCode, $city, $cityIDs){
        $this->userAgent = $userAgent;
        $this->isoCode = $isoCode;
        $this->city = $city;
    }
    public function __destruct(){}
    
    function setCityId($isoCode, $city, $cityIDs){
        foreach($cityIDs as $key => $value){
            if($value['country'] === $isoCode && $value['name'] === $city){
                return $value['id'];
            }
        }
    }
    
    
    function cityById($id){
        if(file_exists("../weatherdata/weather$id.json") === false){
            /* TODO ::
             *  do in timed queue
             */
            $teamKey = self::$teamKey;
            $userAgent = $this->userAgent;
            $url = "api.openweathermap.org/data/2.5/forecast?id=$id&appid=$teamKey";
            $resp = self::setCURL($userAgent, $url);
            
            self::buildJSON($id, $resp);
            $response = json_decode($resp);
             header('Content-Type: application/json');
            echo json_encode($response, JSON_PRETTY_PRINT);
            
            $resp = null;
            $response = null;
        }
        else{
            
             $t = time();
             echo "".filemtime("../weatherdata/weather$id.json")."\n"."$t";
            $resp = file_get_contents("../weatherdata/weather$id.json");
            $response = json_decode($resp);
            header('Content-Type: application/json');
            echo json_encode($response, JSON_PRETTY_PRINT);
            $resp = null;
            $response = null;
        }
        fclose("../weatherdata/weather$id.json");
    }
    
    function setCURL($userAgent, $url){
        $curl = curl_init();
        curl_setopt_array($curl, array(
            CURLOPT_URL => $url,
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_USERAGENT => $userAgent,
            CURLOPT_MAXREDIRS => 10,
            CURLOPT_TIMEOUT => 30,
        ));
        $resp = curl_exec($curl);
        curl_close($curl);
        if(!$resp) {
            die('Error: "' . curl_error($curl) . '" - Code: ' . curl_errno($curl));
        }
        return $resp;
    }
    
    function buildJSON($id, $resp){
        $file = fopen("../weatherdata/weather$id.json", "w");
        file_put_contents("../weatherdata/weather$id.json", "");
        fwrite($file, $resp);
        $file = null;
    }
}


getWeather::__destruct;
die();
