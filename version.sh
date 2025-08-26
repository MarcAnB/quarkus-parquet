#!/bin/bash

export LAST_VERSION=$(git describe --abbrev=0 --tags | cut -c 2-)
if [ -z "$LAST_VERSION" ];
then
  # setting default version, since we do not have a tag
  export LAST_VERSION="0.0.0"
fi
export VERSION_BITS=(${LAST_VERSION//./ })
if [ "${#VERSION_BITS[@]}" -ne 3 ]; then
  # setting default version, since last tag is not uniform
  export LAST_VERSION="0.0.0"
  export VERSION_BITS=(${LAST_VERSION//./ })
fi
# get number parts and increase last one by 1
export VNUM1=${VERSION_BITS[0]}
export VNUM2=${VERSION_BITS[1]}
export VNUM3=${VERSION_BITS[2]}

#if [[ ${GITHUB_REF#refs/heads/} = feature/* ]] || [[ ${GITHUB_HEAD_REF} = feature/* ]]; then
#  export VNUM2=$((VNUM2+1))
#  export VNUM3=0
#else
export VNUM3=$((VNUM3+1))
#fi

#set new version
export NEXT_VERSION="$VNUM1.$VNUM2.$VNUM3"

echo -n $NEXT_VERSION-SNAPSHOT
