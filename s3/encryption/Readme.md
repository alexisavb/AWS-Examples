## Create a bucket
```sh
aws s3 mb s3://encryption-ao-01
```

## Create a file
```sh
echo "Hello world" > hello.txt
aws s3 cp hello.txt s3://encryption-ao-01
```

## Put object with encrytion of KMS
## https://docs.aws.amazon.com/cli/latest/reference/s3api/put-object.html
## https://docs.aws.amazon.com/cli/latest/reference/kms/create-key.html
```sh
aws s3api put-object \
--bucket encryption-ao-01 \
--key hello.txt --body hello.txt \
--server-side-encryption aws:kms\
--ssekms-key-id [id]
```

## Cleanup
```sh
aws s3 rm s3://encryption-ao-01/hello.txt
aws s3 rb s3://encryption-ao-01
```