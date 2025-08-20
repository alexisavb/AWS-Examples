## Create our bucket 
```sh
aws s3 mb s3://ao-prefixes-01
```

## Create our folder
```sh
aws s3api put-object --bucket ao-prefixes-01 --key "hello/"
```

## Create many folders
```sh
aws s3api put-object --bucket ao-prefixes-01 --key "h/e/l/l/o/h/o/l/a"
```