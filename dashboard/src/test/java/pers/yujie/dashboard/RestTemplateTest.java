package pers.yujie.dashboard;

import cn.hutool.core.util.URLUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@SpringBootTest
public class RestTemplateTest {

//http://template-8gf1js6t49b08525-1316531086.tcloudbaseapp.com/text.html
  //https://sweet-disk-1484.on.fleek.co/text.html
  //http://8.222.141.28:8080/ipfs/Qmb6viDTrohAEHro38hprreSVyKqSvrk1E94k9HVo24ifu/text.html
  //http://192.168.80.128:8080/ipfs/Qmb6viDTrohAEHro38hprreSVyKqSvrk1E94k9HVo24ifu/text.html
  @Test
  void restTemplateTestGet() {
    String url = "http://localhost:6001/webdriver?url={url}&mode={mode}";

    Map<String, String> map = new HashMap<>();
    map.put("url", "https://template-8gf1js6t49b08525-1316531086.tcloudbaseapp.com/text.html");
    map.put("mode", "firefox");

    RestTemplate client = new RestTemplate();
    ResponseEntity<String> response = client.getForEntity(url, String.class, map);
    String body = response.getBody();
    assert body != null;
    HttpStatus status = response.getStatusCode();
    System.out.println(response.getStatusCodeValue());

  }

  @Test
  void testRe() {
      for (int i = 0; i < 50; i++) {
        System.out.println("test " + i);
        restTemplateTestGet();
      }
  }

  @Test
  void testContain() throws MalformedURLException {
//      URI uri = new URI("www");
      String url = "http:///www.baidu";
    try {
      url = URLUtil.normalize(url);
      URL urlTest = new URL(url);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    System.out.println(url);
//      System.out.println(uri);
//      System.out.println(URLUtil.isFileURL(uri.toURL()));
//      System.out.println(uri.getScheme());
//      System.out.println(uri.getHost());

  }

}