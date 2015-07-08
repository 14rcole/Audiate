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


ffmpeg -i "$1" -acodec pcm_s16le -ac 2 ../Audio\ Files/${audioTitle}
