package query;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import model.BookDataModel;
import model.Subfield;

import java.util.ArrayList;
import java.util.List;

public class FindSubfieldQuery {

    static String subFieldQueryString = "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
            "PREFIX book: <http://example.org/book/>\n" +
            "PREFIX dc: <http://purl.org/dc/elements/1.1/>\n" +
            "PREFIX ns: <http://example.org/ns#>\n" +
            "SELECT ?subject ?subTopic {\n" +
            "  \t  SERVICE <http://ec2-3-17-141-90.us-east-2.compute.amazonaws.com:3030/subject/sparql> {\n" +
            "\t\t    ?example ns:object ?subTopic .\n" +
            "\t\t    ?example ns:predicate ?predicate FILTER (?predicate = \"superTopicOf\").\n" +
            "    \t\t?example ns:subject ?subject FILTER (?subject = \"fieldName\").\n" +
            "      }\n" +
            "}";

    public static List<Subfield> findSubFieldQuery(String queryParam) throws Exception {
        queryParam = subFieldQueryString.replace("fieldName", queryParam);
        ResultSet results = JenaCommons.runQuery(queryParam);
        List<Subfield> subFieldList = new ArrayList<>();

        while(results.hasNext()) {
            QuerySolution row = results.next();
            String superTopic = row.getLiteral("?subTopic") != null ? row.getLiteral("?subTopic").toString() : "NULL";

            Subfield subfield = new Subfield(superTopic);
            subFieldList.add(subfield);
        }

        return subFieldList;
    }

    public static void main(String args[]) throws Exception {
        List<Subfield> fieldList = FindSubfieldQuery.findSubFieldQuery("Machine Learning");
        System.out.println(fieldList);
    }
}