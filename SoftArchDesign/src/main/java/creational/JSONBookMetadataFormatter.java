package creational;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {
    private JSONObject books;

    public JSONBookMetadataFormatter() throws  IOException {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        books = new JSONObject();
        books.put("Books" , new JSONArray());

        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        JSONArray listBook = (JSONArray) books.get("Books");
        JSONObject book = new JSONObject();
        String[] author = b.getAuthors();
        JSONArray listAuthor = new JSONArray();
        for ( int i=0; i< author.length;i++){
            listAuthor.add(author[i]);
        }
        book.put("ISBN",b.getISBN());
        book.put("Authors",listAuthor);
        book.put("Title",b.getTitle());
        book.put("Publisher", b.getPublisher());

        listBook.add(book);

    return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return books.toJSONString();
    }
}
