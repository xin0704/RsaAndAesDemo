# RsaAndAesDemo

## 描述
基于retrofit2封装的RSA加密demo 如有不当之处  请各位大神指教

## RSA秘钥生成
### 打开OpenSSL秘钥生成软件
OpenSSL下载地址：https://www.openssl.org/
1.打开 openssl 文件夹下的 bin 文件夹,执行 openssl.exe 文件
2.输入“genrsa -out rsa_private_key.pem 1024”命令,回车后,在当前 bin 文件目录中会新增一个rsa_private_key.pem 文件,其文件为私钥
3.输入“rsa -in rsa_private_key.pem -pubout -out rsa_public_key.pem”命令回车 后,在当前 bin 文件目录中会新增一个 rsa_public_key.pem 文件,其文件为公钥
4.生成PKCS8 编码的私钥：输入命令“pkcs8 -topk8 -inform PEM -in rsa_private_key.pem -outform PEM -nocrypt”并回车
