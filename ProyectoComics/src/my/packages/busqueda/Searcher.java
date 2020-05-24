package my.packages.busqueda;

import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;

import my.packages.Comic.Tomo;
import my.packages.Estructuras.DynamicArray;

public class Searcher {
	
	private final String indexDirectory = "C:/Users/Agustin/Documents/proyectoestructuras/data/index";
	
	public Document crearTomoIndex(Tomo tomoAgregar)
	{
	   Document tomo = new Document();

	   IndexableField nombreField = new TextField("NOMBRE",
	      tomoAgregar.getNombre(),
	      Field.Store.YES);
	   String[] autor = tomoAgregar.getEscritor().getNombre().split("_");
	   String[] dibujante = tomoAgregar.getDibujante().getNombre().split("_");
	   
	   IndexableField autorField = new TextField("AUTOR",
	      autor[0] +" " + autor[1] + " " +  dibujante[0] +" " + dibujante[1],
	      Field.Store.NO);
	   IndexableField categoryField = new TextField("CATEGORIAS",
	      tomoAgregar.getCategorias().toString(),
	      Field.Store.NO);

	   tomo.add(nombreField);
	   tomo.add(autorField);
	   tomo.add(categoryField);

	   return tomo;
	}
	
	public void indexTomo(Document tomo) throws Exception
	{
	   IndexWriter iw = null;
	   IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
	   config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
	   try
	   {
	      Directory indexDirectorio =
	            FSDirectory.open(Paths.get(indexDirectory));

	      iw = new IndexWriter(indexDirectorio, config);
	      iw.addDocument(tomo);
	      iw.flush();
	      iw.commit();
	   }
	   finally
	   {
	      if (iw != null)
	      {
	         iw.close();
	      }
	   }
	}
	
	public DynamicArray<String> buscarTomo(String nombreTomo, int numeroBusqueda)
	{
	   DynamicArray<String> nombreTomos = new DynamicArray();
	   String tipoBusqueda = toTipoBusqueda(numeroBusqueda);
	   try
	   {
		   
	      Directory dirOfIndexes =
	            FSDirectory.open(Paths.get(indexDirectory));

	      IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(dirOfIndexes));
	      
	      QueryBuilder builder = new QueryBuilder(new StandardAnalyzer());

	      Query q = null;
	      
	      switch (numeroBusqueda) {
			case 0:
				q = builder.createPhraseQuery("NOMBRE", nombreTomo);
				break;
			case 1:
				q = builder.createPhraseQuery("AUTOR", nombreTomo);
				break;
			case 2:
				q = builder.createPhraseQuery("CATEGORIAS", nombreTomo);
				break;
			default:
				System.out.println("El tipo de busqueda ingresado no concuerda con los existentes");
				System.exit(1);
			}    

	      BooleanQuery.Builder chainQryBldr = new BooleanQuery.Builder();
	      chainQryBldr.add(q, Occur.SHOULD);

	      BooleanQuery finalQuery = chainQryBldr.build();

	      TopDocs tomosEncontrado = searcher.search(finalQuery, 10);
	      if (tomosEncontrado.scoreDocs != null)
	      {
	         for (ScoreDoc doc : tomosEncontrado.scoreDocs)
	         {
	            int tomoid = doc.doc;
	            Document tomoEncontrado = searcher.doc(tomoid);
	            if (tomoEncontrado != null)
	            {
	            	IndexableField field = tomoEncontrado.getField("NOMBRE");
	            	
	            	if(field != null) 
	            	{
	            		nombreTomos.pushBack(field.stringValue());
	            	}            	
	            }
	         }
	      }
	   }
	   catch (Exception ex)
	   {
		   
	      System.out.println("Error en la busqueda de Tomo, por medio de: " + tipoBusqueda);
	   }

	   return nombreTomos;
	}

	private String toTipoBusqueda(int numeroBusqueda) {
		switch (numeroBusqueda) {
		case 0:
			return "Nombre";
		case 1:
			return "Autor";
		case 2:
			return "Categoria";

		default:
			return "";
		}
	}
}
