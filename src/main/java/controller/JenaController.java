package controller;


import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class JenaController {

    static String findAllBooks = "PREFIX owl: <http://www.w3.org/2002/07/owl#>" +
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

    String testQuery = "PREFIX ab: <http://learningsparql.com/ns/addressbook#>" +
            "SELECT (COUNT(?s) as ?sCount)" +
            "WHERE {" +
            " ?s ?p ?o ." +
            "}";

    public void runJena(String sparqlQuery) throws Exception {
        Model model = ModelFactory.createDefaultModel();
//        model = model.read(getClass().getClassLoader().getResource("SearchPage.fxml").toString());
        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);

        ResultSet results = queryExecution.execSelect();

        while(results.hasNext()) {
            QuerySolution row = results.next();
            String value1 = row.getLiteral("?title") != null ? row.getLiteral("?title").toString() : "NULL";
            String value2 = row.getLiteral("?subject") != null ? row.getLiteral("?subject").toString() : "NULL";
            String value3 = row.getLiteral("?creator") != null ? row.getLiteral("?creator").toString() : "NULL";
            System.out.println("---------");
            System.out.println(value1);
            System.out.println(value2);
            System.out.println(value3);
            System.out.println("----------");
        }
    }

    public static void main(String args[]) throws Exception {
        JenaController controller = new JenaController();
        controller.runJena(findAllBooks);
    }

}
