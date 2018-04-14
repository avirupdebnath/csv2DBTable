package CSV_2_DB;
import connectionDB.myDBConnectorUpdater;       //package from DB_CSV_OPS_API that has been made
import csvOps.csvToArray;                       //package from DB_CSV_OPS_API that has been made
import java.sql.Connection;

public class csv2db {

	public static void main(String[] args) {
		
		//variables required
		String fileurl="src\\data\\mydata.csv"; 	//csv file location
		String DBurl="jdbc:mysql://sql12.freesqldatabase.com/sql12232496"; //db location
		String user="sql12232496";		
		String pass="19971207";
		String tableName="Student";			//db table name
		String columnNames="Name,Contact_No,Address";	//table column heads
		
		//no. of rows to be updated
		int rows=csvToArray.getLines(fileurl);
		System.out.println("Total no. of rows requesting update:"+rows);
		
		//get each row
		String columns[]=csvToArray.getColumns();
		
		//connect to th db table and update
		try {
			Connection conn=myDBConnectorUpdater.getConnection(DBurl, user, pass);
			myDBConnectorUpdater.insert(conn, tableName, columnNames, columns, rows);
		}
		catch(Exception e) {System.out.println(e);}

	}

}
