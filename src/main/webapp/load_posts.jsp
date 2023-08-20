<%@page import="com.tech.blog.entities.User"%>
<%@page import="com.tech.blog.dao.LikeDao"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>


<div class="row">

<% 

User user= (User)session.getAttribute("currentUser");

PostDao d = new PostDao(ConnectionProvider.getConnection());

int cid = Integer.parseInt(request.getParameter("cid"));
List<Post> posts=null;

if(cid==0){
//load all post
 posts =  d.getAllPost();
	
}else{
	posts=d.getPostByCatId(cid);
}

if(posts.size()==0){
	out.println("<h3 class='display-3 text-center'>No Posts Available.</h3>");
	return;
}

for(Post p: posts){
	
%>
	
	<div class="col-md-6 mt-2">
		<div class="card">
			
			<img alt="" src="blog_pic/<%= p.getpPic() %>" class="card-img-top">
			
			<div class="card-body">
			
				<b><%= p.getpTitle() %></b>
				<p><%= p.getpContent() %></p>	
			
			</div>
			<div class="card-footer primary-background text-center">
			
			<%
			LikeDao ld= new LikeDao(ConnectionProvider.getConnection());
			
			%>
			
			<a href="#!" onclick="doLike(<%= p.getPid() %>,<%= user.getId() %>)" class="btn btn-outline-primary btn-sm"><i class="fa fa-thumbs-o-up"></i><span class="like-counter"><%= ld.countLikeOnPost(p.getPid()) %></span></a>
			<a href="show_blog_page.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-primary btn-sm">Read More..</a> 
			<a href="#!" class="btn btn-outline-primary btn-sm"><i class="fa fa-commenting-o"></i><span>10</span></a>
			
			</div>	
		
		</div>
	
	
	</div>
	
	<%
	
}

%>

</div>