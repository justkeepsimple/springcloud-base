生成用于Token加密的私钥文件fzp-jwt.jks

keytool -genkeypair -alias fzp-jwt 
          -validity 3650 
          -keyalg RSA 
          -dname "CN=jwt,OU=jtw,O=jwt,L=zurich,S=zurich, C=CH" 
          -keypass fzp123 
          -keystore fzp-jwt.jks 
          -storepass fzp123
          
其中，-alias 选项为 别名，-keyalg 为 加密算法，-keypass 和 -storepass 为 
密码选项，-keystore 为 jks 的 文件名称，-validity 
为配置 jks 文件 过期时间（单位：天）。
          
          
对于资源服务，需要使用jks的 
公钥对JWT进行解密。获取jks文件的公钥的命令如下：
keytool -list -rfc 
          --keystore fzp-jwt.jks | openssl x509 
          -inform pem 
          -pubkey
          
这个命令要求安装 openSSL


输入密码 fzp123 后 显示的信息很多，只需要提取 PUBLIC KEY，即如下所示

-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlCFiWbZXIb5kwEaHjW+/
7J4b+KzXZffRl5RJ9rAMgfRXHqGG8RM2Dlf95JwTXzerY6igUq7FVgFjnPbexVt3
vKKyjdy2gBuOaXqaYJEZSfuKCNN/WbOF8e7ny4fLMFilbhpzoqkSHiR+nAHLkYct
OnOKMPK1SwmvkNMn3aTEJHhxGh1RlWbMAAQ+QLI2D7zCzQ7Uh3F+Kw0pd2gBYd8W
+DKTn1Tprugdykirr6u0p66yK5f1T9O+LEaJa8FjtLF66siBdGRaNYMExNi21lJk
i5dD3ViVBIVKi9ZaTsK9Sxa3dOX1aE5Zd5A9cPsBIZ12spYgemfj6DjOw6lk7jkG
9QIDAQAB
-----END PUBLIC KEY-----