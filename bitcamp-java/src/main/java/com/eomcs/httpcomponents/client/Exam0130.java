// Apache HttpComponents 사용법: HttpClient5 - GET 요청하기
package com.eomcs.httpcomponents.client;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class Exam0130 {
  public static void main(String[] args) throws Exception {


    // copy



    try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
      HttpGet httpGet = new HttpGet("http://www.daum.net");
      try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
        System.out.println(response1.getCode() + " " + response1.getReasonPhrase());
        HttpEntity entity1 = response1.getEntity();
        EntityUtils.consume(entity1);
      }
    }
  }
}
