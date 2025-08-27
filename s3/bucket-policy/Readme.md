## Create a new bucket
```sh
aws s3api create-bucket --bucket bucket-policy-ao-01 --region us-east-1
```

##
## https://docs.aws.amazon.com/cli/latest/reference/s3api/put-bucket-policy.html
```sh
aws s3api put-bucket-policy --bucket bucket-policy-ao-01 --policy file://policy.json
```

## Cleanup
```sh
aws s3 rb s3://bucket-policy-ao-01
```