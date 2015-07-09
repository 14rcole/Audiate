#!/bin/bash
echo $1
inputTitle=${1};
outputTitle="";

function getTitle {
	filename="${inputTitle##*/}"
	outputTitle="${filename%.*}"
	outputTitle=$outputTitle".wav"
	echo ${outputTitle}
}

function replaceSpaces {
	outputTitle=$(echo $outputTitle | sed 's/\ /\\ /g')
}

getTitle

pwd
ffmpeg -i "$1" -acodec pcm_s16le -ac 1 -ar 10240 "Audio/${outputTitle}"
