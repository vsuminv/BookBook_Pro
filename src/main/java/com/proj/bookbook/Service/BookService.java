package com.proj.bookbook.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.proj.bookbook.DTO.BookDTO;
import com.proj.bookbook.Model.Book;
import com.proj.bookbook.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    RestTemplate restTemplate = new RestTemplate();
    String strurl;
    public void book_list() {
//        ArrayList<BookDTO> arrayList=new ArrayList<BookDTO>();
        List<Book> bookList = new ArrayList<>();
        strurl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbtnalsdl50750105003&QueryType=ItemNewAll&MaxResults=10&start=1&SearchTarget=Book&output=js&Version=20131101";

        JSONArray jsonArray = JSONParsing(strurl);


        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject date = (JSONObject) jsonArray.get(i);


            BookDTO bookDTO = new BookDTO(
                    date.get("isbn").toString(),
                    date.get("categoryName").toString(),
                    date.get("title").toString(),
                    date.get("author").toString(),
                    date.get("pubDate").toString(),
                    date.get("cover").toString(),
                    date.get("description").toString(),
                    date.get("publisher").toString()

            );
            Book book = Book.builder()
                    .book_id(bookDTO.getBook_id())
                    .book_isbn13(bookDTO.getBook_isbn13())
                    .book_category(bookDTO.getBook_category())
                    .book_title(bookDTO.getBook_title())
                    .book_author(bookDTO.getBook_author())
                    .book_pubdate(bookDTO.getBook_pubdate())
                    .book_img(bookDTO.getBook_img())
                    .book_content(bookDTO.getBook_content())
                    .book_publisher(bookDTO.getBook_publisher())
                    .build();
            bookList.add(book);

        }

        bookRepository.saveAll(bookList);

    }


    private JSONArray JSONParsing(String strurl) {
        JSONArray JsonArray=null;
        StringBuffer stringBuffer =new StringBuffer();
        try{
            URL url = new URL(strurl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
            String stringline;

            while ((stringline = bufferedReader.readLine()) != null) {
                stringBuffer.append(stringline + "\n");
            }

            JSONParser jsonParser=new JSONParser();
            JSONObject jsonObject=(JSONObject) jsonParser.parse(String.valueOf(stringBuffer));
            JsonArray=(JSONArray) jsonObject.get("item");
            httpURLConnection.disconnect();

        }catch (Exception e){
            System.out.println("JSONParsing 오류"+e);
        }
        return JsonArray;
    }

    @Transactional
    public List<Book> findAll() {

        return bookRepository.findAll();
    }


}

        



