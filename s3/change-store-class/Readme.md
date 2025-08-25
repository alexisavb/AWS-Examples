## Create a bucket
```sh
aws s3 mb s3://class-fun-ao-01
```

## Create a file
```sh
echo "Hello world" > hello.txt
aws s3 cp hello.txt s3://class-fun-ao-01 --storage-class STANDARD_IA
```

## Clean up
```sh
aws s3 rm s3://class-fun-ao-01/hello.txt
aws s3 rb s3://class-fun-ao-01
```