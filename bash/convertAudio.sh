#!/bin/bash
echo $1
videoTitle=${1};
audioTitle="";

function getTitle {
        filename="${videoTitle##*/}"
        audioTitle="${filename%.*}"
        audioTitle=$audioTitle".wav"
        echo ${audioTitle}
}

getTitle


ffmpeg -i "$1" -ar 22050 ../Audio\ Files/${audioTitle}

