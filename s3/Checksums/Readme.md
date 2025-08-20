## create a new S3 bucket

```sh
./create-bucket ao-checksums-01
```

## Create a file that will we do checksum on

```sh
echo "Hello Alexis Osnaya" > checksumsFile.txt
```

## Get a checksum of a file for MD5
md5sum checksumsFile.txt
# aa9a1b7b8d6e2ae3a301b832fda09f88

## Upload our file and look at its etag
```sh
aws s3 cp checksumsFile.txt s3://ao-checksums-01
aws s3api head-object --bucket ao-checksums-01 --key checksumsFile.txt
```

## Lets upload a file with a different kind of checksum -> CRC32
```sh
cksum checksumsFile.txt
aws s3api put-object \
--bucket ao-checksums-01 \
--body checksumsFile.txt \
--key checksumsFile.txt \
--checksum-algorithm CRC32 \
```
# 187843715 20 checksumsFile.txt