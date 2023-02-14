#!/bin/bash

# Set the directory path
dir_path="./protos"

# Delete all files and subdirectories in the directory
rm -rf $dir_path/*

# Create a new, empty directory if it does not exist
if [ ! -d "$dir_path" ]; then
  mkdir $dir_path
fi

# Set the proto repository name and target directory
repo_name="particle-protocol"
target_dir="protos"

# Clone the repository
git clone https://github.com/what-s-particle/$repo_name.git

# Remove all files and directories except for the target directory
cd $repo_name
find . ! -path "./$target_dir*" -delete

# Move the target directory to the current directory
cd ..

mv $repo_name/$target_dir .

# Remove the cloned repository
rm -rf $repo_name

# Define the directory containing the PB files
pb_dir="./protos"
# Define the name of the new PB file
new_pb_dir="./generate"
new_pb_file="./generate/particle.proto"

# Define the directory of Kotlin file
gen_kt_dir="./generate/java"

# Define the directory of target Kotlin file
new_kt_dir="./src/main/java"

rm -rf $new_pb_dir/*
if [ ! -d "$new_pb_dir" ]; then
  mkdir $new_pb_dir
fi

# Delete all files and subdirectories in the build directory
rm -rf $gen_kt_dir/*
if [ ! -d "$gen_kt_dir" ]; then
  mkdir $gen_kt_dir
fi

rm -rf $gen_kt_dir/*
if [ ! -d "$gen_kt_dir" ]; then
  mkdir $gen_kt_dir
fi

# Clear the content of the new file
echo "" >"${new_pb_file}"

# Recursively search for PB files in the specified directory
for pb_file in $(find "${pb_dir}" -name "*.proto"); do
  # Exclude "syntax", "package" and "import" lines
  grep -v '^syntax' "${pb_file}" | grep -v '^package' | grep -v '^import' >>"${new_pb_file}"
done

# Remove extra blank lines
sed -i '/^$/d' "${new_pb_file}"

# Add a new line after each '}'
sed -i '/}/{G;}' "${new_pb_file}"

# Add "syntax" , "import" and "new line" lines to the beginning of the file
echo "" | cat - "${new_pb_file}" >temp && mv temp "${new_pb_file}"
echo "option java_multiple_files = true;" | cat - "${new_pb_file}" >temp && mv temp "${new_pb_file}"
echo "option java_package = 'com.yunlong.particle.proto';" | cat - "${new_pb_file}" >temp && mv temp "${new_pb_file}"
echo "package com.yunlong.particle.proto;" | cat - "${new_pb_file}" >temp && mv temp "${new_pb_file}"
echo "syntax = 'proto3';" | cat - "${new_pb_file}" >temp && mv temp "${new_pb_file}"


java -jar ./wire-compiler-4.5.0-jar-with-dependencies.jar --proto_path=. --android --kotlin_out=${gen_kt_dir} ${new_pb_file}


rm -rf $new_pb_file


# Move each subdirectory to the parent directory

rm -rf "${new_kt_dir}/com/yunlong"

cp -r "${gen_kt_dir}/com" "${new_kt_dir}"
rm -rf "${pb_dir}"
rm -rf "${new_pb_dir}"
