package com.oseanchen.demotest.restTemplate;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class RestTemplateDemo {
    static RestTemplate restTemplate = new RestTemplate();
    static String urlForGet = "https://jsonplaceholder.typicode.com/posts/1";
    static String UrlForPost = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) {
//        getForObject();
//        getForEntity();
//        postForObject();
//        postForEntity();
//        exchangeWithGet();
//        exchangeWithPost();
//        put();
//        delete();
    }
    /**
     * getForObject
     * GET
     * response 只有回傳 api 回應內容，不帶有 header, response code...
     */
    public static String getForObject(){
        System.out.println("--- do getForObject ---");
        String response = restTemplate.getForObject(urlForGet, String.class);
        System.out.println(response);
        return response;
    }

    public static String postForObject(){
        System.out.println("--- do postForObject ---");
        HashMap<String, String> mapPost = new HashMap<>();
        mapPost.put("title", "新的文章標題");
        mapPost.put("body", "大家好，我是Sean!!");
        String response = restTemplate.postForObject(UrlForPost, mapPost, String.class);
        System.out.println(response);
        return response;
    }

    /**
     * getForEntity
     * GET
     * response 組成 ResponseEntity ，內含 body, header, response code...
     */
    public static ResponseEntity<String> getForEntity(){
        System.out.println("--- do getForEntity ---");
        ResponseEntity<String> response = restTemplate.getForEntity(urlForGet, String.class);
        System.out.println(response);
        return response;
    }

    /**
     * postForEntity
     * POST
     * 設定 header, body 等至 HttpEntity ， 回傳 response 為 ResponseEntity，內含 body, header, response code...
     */
    public static ResponseEntity<String> postForEntity(){
        System.out.println("--- do postForEntity ---");
        HashMap<String, String> mapPost = new HashMap<>();
        mapPost.put("title", "新的文章標題");
        mapPost.put("body", "大家好，我是Sean!!");
        ResponseEntity<String> response = restTemplate.postForEntity(UrlForPost, mapPost, String.class);
        System.out.println(response);
        return response;
    }

    /**
     * exchange
     * (GET) 適用任何 http method。
     * 設定 header, body 等至 HttpEntity ， 回傳 response 為 ResponseEntity，內含 body, header, response code...
     */
    public static String exchangeWithGet(){
        // 設定 header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 建立 HttpEntity 物件，包含請求頭及請求內容（可以省略）
        HttpEntity<String> request = new HttpEntity<>("", headers);

        // 執行 GET 請求，並取得回應資料
        ResponseEntity<String> response = restTemplate.exchange(urlForGet, HttpMethod.GET, request, String.class);

        // 讀取回應內容
        String responseBody = response.getBody();
        System.out.println(responseBody);
        return responseBody;
    }

    /**
     * exchange
     * (POST) 適用任何 http method。
     * 設定 header, body 等至 HttpEntity ， 回傳 response 為 ResponseEntity，內含 body, header, response code...
     */
    public static ResponseEntity<String> exchangeWithPost(){
        System.out.println("--- do exchangeWithPost ---");

        // 設定 header
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        // 建立 HttpEntity 物件，包含請求頭及請求內容（可以省略）
        Post post = new Post("新的文章標題", "大家好，我是Sean!!");
        HttpEntity<Post> request = new HttpEntity<>(post, headers);

        // 執行 GET 請求，並取得回應資料
        ResponseEntity<String> response = restTemplate.exchange(UrlForPost, HttpMethod.POST, request, String.class);

        // 讀取回應內容
        System.out.println(response);
        return response;
    }


    /**
     * put
     * PUT
     * 沒有回傳值
     */
    public static void put(){
        String url = "https://jsonplaceholder.typicode.com/posts/2";
        Post post = new Post("修改文章標題", "修改文章內容");
        restTemplate.put(url, post);
    }

    /**
     * delete
     * DELETE
     * 沒有回傳值
     */
    public static  void delete(){
        String url = "https://jsonplaceholder.typicode.com/posts/3";
        restTemplate.delete(url);
    }
}
