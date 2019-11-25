package query;

import com.hp.hpl.jena.query.*;
import model.BookDataModel;

import java.util.ArrayList;
import java.util.List;

public class FindBooksQuery {

    private static final String SPACE = " ";
    private static String findAllBooks = "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
    "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
    "PREFIX book: <http://example.org/book/>" +
    "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
    "SELECT ?title ?subject ?creator { "+
        "SERVICE <http://ec2-3-134-118-190.us-east-2.compute.amazonaws.com:3030/books/sparql> {" +
        "SELECT DISTINCT ?title ?creator ?subject " +
        "WHERE { " +
                    "?books dc:title ?title ." +
                    "?books dc:subject ?subject ." +
                    "?books dc:creator ?creator ." +

    " }}}";

    private static String findBookByTitle = "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
            "PREFIX book: <http://example.org/book/>" +
            "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
            "SELECT ?title ?subject ?creator { "+
            "SERVICE <http://ec2-3-134-118-190.us-east-2.compute.amazonaws.com:3030/books/sparql> {" +
            "SELECT DISTINCT ?title ?creator ?subject " +
            "WHERE { " +
            "?books dc:title ?title FILTER (?title = \"bookTitle\") ." +
            "?books dc:subject ?subject ." +
            "?books dc:creator ?creator ." +

            " }}}";

    private static String findBooksByAuthorSingleName = "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
            "PREFIX book: <http://example.org/book/>" +
            "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
            "SELECT ?title ?subject ?creator { "+
            "SERVICE <http://ec2-3-134-118-190.us-east-2.compute.amazonaws.com:3030/books/sparql> {" +
            "SELECT DISTINCT ?title ?creator ?subject " +
            "WHERE { " +
            "?books dc:title ?title . " +
            "?books dc:subject ?subject . " +
            "?books dc:creator ?creator FILTER (contains(str(?creator), \"authorName\" )) . " +

            " }}}";

    private static String findBooksByAuthorFirstAndLastName = "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
            "PREFIX book: <http://example.org/book/>" +
            "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
            "SELECT ?title ?subject ?creator { "+
            "SERVICE <http://ec2-3-134-118-190.us-east-2.compute.amazonaws.com:3030/books/sparql> {" +
            "SELECT DISTINCT ?title ?creator ?subject " +
            "WHERE { " +
            "?books dc:title ?title . " +
            "?books dc:subject ?subject . " +
            "?books dc:creator ?creator FILTER (contains(str(?creator), \"firstName\" ) && contains(str(?creator), \"lastName\" )) . " +

            " }}}";

    private static String findBooksBySubject = "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
            "PREFIX book: <http://example.org/book/>" +
            "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
            "SELECT ?title ?subject ?creator { "+
            "SERVICE <http://ec2-3-134-118-190.us-east-2.compute.amazonaws.com:3030/books/sparql> {" +
            "SELECT DISTINCT ?title ?creator ?subject " +
            "WHERE { " +
            "?books dc:title ?title ." +
            "?books dc:subject ?subject FILTER (?subject = \"subjectName\") ." +
            "?books dc:creator ?creator ." +

            " }}}";

    public static List<BookDataModel> findAllBooks() throws Exception {
        return findBooksQuery(findAllBooks);
    }

    public static List<BookDataModel> findBookByTitle(String bookTitle) throws Exception {
        String findByTitle = findBookByTitle.replace("bookTitle", bookTitle);
        return findBooksQuery(findByTitle);
    }

    public static List<BookDataModel> findBookByAuthor(String authorName) throws Exception {
        String names[] = authorName.split(SPACE);
        String findBooksByAuthor;
        if(names.length == 2) {
            findBooksByAuthor = findBooksByAuthorFirstAndLastName.replace("firstName", names[0]);
            findBooksByAuthor = findBooksByAuthor.replace("lastName", names[1]);
        } else {
            findBooksByAuthor = findBooksByAuthorSingleName.replace("authorName", authorName);
        }

        return findBooksQuery(findBooksByAuthor);
    }

    public static List<BookDataModel> findBookBySubject(String subjectName) throws Exception {
        String findBookBySubject = findBooksBySubject.replace("subjectName", subjectName);
        return findBooksQuery(findBookBySubject);
    }

    public static List<BookDataModel> findBooksQuery(String queryParam) throws Exception {
        ResultSet results = JenaCommons.runQuery(queryParam);
        List<BookDataModel> bookDataModelList = new ArrayList<>();

        while(results.hasNext()) {
            QuerySolution row = results.next();
            String title = row.getLiteral("?title") != null ? row.getLiteral("?title").toString() : "NULL";
            String subject = row.getLiteral("?subject") != null ? row.getLiteral("?subject").toString() : "NULL";
            String creator = row.getLiteral("?creator") != null ? row.getLiteral("?creator").toString() : "NULL";

            BookDataModel bookDataModel = new BookDataModel(title, creator, subject, "");
            bookDataModelList.add(bookDataModel);
        }

        return bookDataModelList;
    }

    public static void main(String args[]) throws Exception {
        FindBooksQuery controller = new FindBooksQuery();
        List<BookDataModel> bookDataModelList = FindBooksQuery.findBookByAuthor("Nicholas Rescher");
        System.out.println(bookDataModelList);

        bookDataModelList = FindBooksQuery.findBookByTitle("Many-valued logic");
        System.out.println(bookDataModelList);

        bookDataModelList = FindBooksQuery.findBookBySubject("Multivalued Logic");
        System.out.println(bookDataModelList);
    }
}