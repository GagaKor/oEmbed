# oEmbed 연습

#### 구현 방법
링크를 통해 검색 시 해당 링크를 oEmbed 형식으로 바꿔준다

```java
private String check(String url) {
	String rs = "";
	if(url.contains("www.youtube.com")) {
		rs = "https://www.youtube.com/oembed?url="+url;
	}else if(url.contains("www.instagram.com")){
		rs = "https://api.instagram.com/oembed?url="+url;
	}else if(url.contains("twitter.com")){
		rs = "https://publish.twitter.com/oembed?url="+url;
	}else if(url.contains("vimeo.com")){
		rs = "https://vimeo.com/api/oembed.json?url="+url;
	}
		return rs;
	}
```

 oEmbed 형식으로 검색
 
```java
RestTemplate rt = new RestTemplate();
String embedRes = rt.getForObject(check(data), String.class);
ObjectMapper objMapper = new  ObjectMapper();
embedResult = objMapper.readValue(embedRes, new TypeReference<Map<String, Object>>() {});

```
---------------------------
#### 출력화면
![11](https://user-images.githubusercontent.com/80230648/127473191-cdecda08-a688-434c-9019-79b5da7ed51b.jpg)

링크 입력시 해당 형식 출력
![321](https://user-images.githubusercontent.com/80230648/127473491-e22cde43-341e-4949-bd94-7185562cc1f5.PNG)

