package query;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import model.BookDataModel;

import java.util.ArrayList;
import java.util.List;

public class FindLocationQuery {

    public static BookDataModel findLocation(String queryParam, BookDataModel bookDataModel) throws Exception {
        ResultSet results = JenaCommons.runQuery(queryParam);
        List<BookDataModel> bookDataModelList = new ArrayList<>();

        while(results.hasNext()) {
            QuerySolution row = results.next();
            String aisle = row.getLiteral("?aisle") != null ? row.getLiteral("?aisle").toString() : "NULL";
            bookDataModel.setLocation(aisle);
            bookDataModelList.add(bookDataModel);
        }

        return bookDataModel;
    }

    public static void main(String[] args) {

    }
}