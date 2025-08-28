## Create a bucket
```sh
aws s3 mb s3://cors-oa-01
```
## Change block public access
## https://docs.aws.amazon.com/cli/latest/reference/s3api/put-public-access-block.html
```sh
aws s3api put-public-access-block \
--bucket cors-oa-01 \
--public-access-block-configuration "BlockPublicAcls=true,IgnorePublicAcls=true,BlockPublicPolicy=false,RestrictPublicBuckets=false"
```
## Create a bucket policy
## https://docs.aws.amazon.com/cli/latest/reference/s3api/put-bucket-policy.html
## https://docs.aws.amazon.com/AmazonS3/latest/userguide/WebsiteAccessPermissionsReqd.html
```sh
aws s3api put-bucket-policy --bucket cors-oa-01 --policy file://policy.json
```
## Turn on static website hosting
## https://docs.aws.amazon.com/cli/latest/reference/s3api/put-bucket-website.html
```sh
aws s3api put-bucket-website --bucket cors-oa-01 --website-configuration file://website.json
```
## Upload our index.html file and include a resource that would be cross-origin
```sh
aws s3 cp index.html s3://cors-oa-01
```

## View the website and see if the index.html is there
## 
```sh
http://cors-oa-01.s3-website.us-west-2.amazonaws.com
```

## Set cors on our bucket
```sh
aws s3api put-bucket-cors --bucket cors-oa-01 --cors-configuration file://cors.json
```

## Cleanup
```sh
aws s3 rm s3://cors-oa-01/index.html
aws s3 rb s3://cors-oa-01
```
