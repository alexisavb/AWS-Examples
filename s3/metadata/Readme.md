## Create our bucket 
```sh
aws s3 mb s3://ao-metadata-01
```

## create a new file
```sh
echo "Hello Mr." > hello.txt
```

## upload file with metadata
```sh
aws s3api put-object --bucket ao-metadata-01 --key hello.txt --body hello.txt --metadata x-amz-meta-planet=Mars 
```

## Get metadata through head object
```sh
aws s3api head-object --bucket ao-metadata-01 --key hello.txt  
```

## cleanup
```sh
aws s3 rm s3://ao-metadata-01/hello.txt
aws s3 rb s3://ao-metadata-01
```