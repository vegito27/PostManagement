package webapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    CloseConnection connection=new CloseConnection();
    GetConnection getConnection=new GetConnection();

    public List<Post> getPost(int userid) {

        List<Post> postlist = new ArrayList<Post>();

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con =getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("select * from posts where userid= " + userid );
            st.executeQuery();

            rs = st.getResultSet();

            while (rs.next()) {
                Post dopost = new Post();
                dopost.setId(rs.getInt("id"));
                dopost.setTitle(rs.getString("title"));
                dopost.setPost(rs.getString("post"));
                postlist.add(dopost);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close all the connections
            connection.Connectionclose(con,st);
        }
        return postlist;
    }

    public void deletepost(int postid) {

        List<Post> postlist = new ArrayList<Post>();

        Connection con = null;

        PreparedStatement st = null;

        ResultSet rs = null;

        try {

            con =getConnection.initializeDatabase("postmanagement");


            st = con.prepareStatement("delete from posts where id=" + postid );

            st.executeUpdate();


        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            // Close all the connections
           connection.Connectionclose(con,st);
        }

    }

    public Post EditPost(int postid){

        Post dopost=new Post();

        Connection con = null;

        PreparedStatement st = null;

        ResultSet rs = null;

        try {

            con =getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("select * from posts where id=" + postid );

            st.executeQuery();

            rs = st.getResultSet();

            while (rs.next()) {

                dopost.setTitle(rs.getString("title"));
                dopost.setPost(rs.getString("post"));
            }
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        finally {
            // Close all the connections
          connection.Connectionclose(con,st);
        }
        return dopost;
    }

    public Post getpost(int postid){

        Post dopost=new Post();

        Connection con = null;

        PreparedStatement st = null;

        ResultSet rs = null;

        try {

            con =getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("select * from posts where id=" + postid );

            st.executeQuery();

            rs = st.getResultSet();

            while (rs.next()) {

                dopost.setTitle(rs.getString("title"));
                dopost.setPost(rs.getString("post"));
            }
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        finally {
            // Close all the connections
            connection.Connectionclose(con,st);
        }
        return dopost;






    }




    public static void main(String[] args) {
        PostDao pd=new PostDao();
         List<Post> postlist =pd.getPost(5);
        System.out.println(postlist.size());

    }


}
