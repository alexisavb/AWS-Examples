## Create a new bucket

```sh
aws s3api create-bucket --bucket acl-example-ao-01 --region us-east-1
```

## Turn of Block Public Access for ACLs
## https://docs.aws.amazon.com/cli/latest/reference/s3api/put-public-access-block.html
```sh
aws s3api put-public-access-block \
--bucket acl-example-ao-01 \
--public-access-block-configuration "BlockPublicAcls=false,IgnorePublicAcls=false,BlockPublicPolicy=true,RestrictPublicBuckets=true"
```

```sh
aws s3api get-public-access-block \
--bucket acl-example-ao-01
```

## Change bucket Ownership
## https://docs.aws.amazon.com/cli/latest/reference/s3api/put-bucket-ownership-controls.html
```sh
aws s3api put-bucket-ownership-controls \
--bucket acl-example-ao-01 \
--ownership-controls="Rules=[{ObjectOwnership=BucketOwnerPreferred}]"
```

## Change ACLs to allow for a user in another AWS Account
## https://docs.aws.amazon.com/cli/latest/reference/s3api/put-bucket-acl.html
```sh
aws s3api put-bucket-acl \
--bucket acl-example-ao-01 \
--grant-full-control emailaddress=user1@example.com,emailaddress=user2@example.com \
--grant-read uri=http://acs.amazonaws.com/groups/global/AllUsers
```

## Access Bucket from other account
```sh
touch bootcam.txt
aws s3 cp bootcam.txt s3://acl-example-ao-01
aws s3 ls s3://acl-example-ao-01
```

## Cleanup
```sh
aws s3 rm s3://acl-example-ao-01/bootcam.txt
aws s3 rb s3://acl-example-ao-01
```