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
