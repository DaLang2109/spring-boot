# Spring Boot 项目API文档


<a name="overview"></a>
## 概览
restful 的风格的练习Demo


### 版本信息
*版本* : 1.0


### URI scheme
*域名* : localhost:8080  
*基础路径* : /


### 标签

* article-controller : Article Controller




<a name="paths"></a>
## 资源

<a name="article-controller_resource"></a>
### Article-controller
Article Controller


<a name="addarticleusingpost"></a>
#### AddArticle
```
POST /test/article
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**article**  <br>*必填*|article|[Article](#article)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据结构类](#6a07b703827829ce0440539d0e6e4d8d)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/test/article
```


###### 请求 body
```
json :
{
  "author" : "string",
  "code" : "string",
  "id" : "string",
  "name" : "string",
  "publishingdate" : "string",
  "reader" : {
    "age" : 0,
    "name" : "string",
    "sex" : "string"
  },
  "readerList" : [ {
    "age" : 0,
    "name" : "string",
    "sex" : "string"
  } ]
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "200,400,500",
  "extend" : "object",
  "msg" : "string"
}
```


<a name="updatearticleusingput"></a>
#### UpdateArticle
```
PUT /test/article
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**article**  <br>*必填*|article|[Article](#article)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据结构类](#6a07b703827829ce0440539d0e6e4d8d)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/test/article
```


###### 请求 body
```
json :
{
  "author" : "string",
  "code" : "string",
  "id" : "string",
  "name" : "string",
  "publishingdate" : "string",
  "reader" : {
    "age" : 0,
    "name" : "string",
    "sex" : "string"
  },
  "readerList" : [ {
    "age" : 0,
    "name" : "string",
    "sex" : "string"
  } ]
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "200,400,500",
  "extend" : "object",
  "msg" : "string"
}
```


<a name="delarticlebyidusingdelete"></a>
#### DelArticleById
```
DELETE /test/article
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据结构类](#6a07b703827829ce0440539d0e6e4d8d)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/test/article
```


###### 请求 query
```
json :
{
  "id" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "200,400,500",
  "extend" : "object",
  "msg" : "string"
}
```


<a name="getarticleusingget"></a>
#### GetArticle
```
GET /test/article/{id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据结构类](#6a07b703827829ce0440539d0e6e4d8d)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/test/article/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "200,400,500",
  "extend" : "object",
  "msg" : "string"
}
```


<a name="delarticleusingdelete"></a>
#### DelArticle
```
DELETE /test/article/{id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据结构类](#6a07b703827829ce0440539d0e6e4d8d)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/test/article/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "200,400,500",
  "extend" : "object",
  "msg" : "string"
}
```


<a name="getarticlesusingget"></a>
#### GetArticles
```
GET /test/articles
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据结构类](#6a07b703827829ce0440539d0e6e4d8d)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/test/articles
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "200,400,500",
  "extend" : "object",
  "msg" : "string"
}
```




<a name="definitions"></a>
## 定义

<a name="article"></a>
### Article

|名称|说明|类型|
|---|---|---|
|**author**  <br>*可选*|**样例** : `"string"`|string|
|**code**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|**样例** : `"string"`|string|
|**name**  <br>*可选*|**样例** : `"string"`|string|
|**publishingdate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**reader**  <br>*可选*|**样例** : `"[readeer](#readeer)"`|[Readeer](#readeer)|
|**readerList**  <br>*可选*|**样例** : `[ "[readeer](#readeer)" ]`|< [Readeer](#readeer) > array|


<a name="readeer"></a>
### Readeer

|名称|说明|类型|
|---|---|---|
|**age**  <br>*可选*|**样例** : `0`|integer (int32)|
|**name**  <br>*可选*|**样例** : `"string"`|string|
|**sex**  <br>*可选*|**样例** : `"string"`|string|


<a name="6a07b703827829ce0440539d0e6e4d8d"></a>
### 通用响应数据结构类

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|请求响应状态码  <br>**样例** : `"200,400,500"`|integer (int32)|
|**extend**  <br>*可选*|**样例** : `"object"`|object|
|**msg**  <br>*可选*|请求结果描述信息  <br>**样例** : `"string"`|string|





