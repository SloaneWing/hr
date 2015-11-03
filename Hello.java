public class Hello{
	public static void main(String args[]){
		short x = 1;
		x += 1;
		System.out.println(x);
	}
}


Collection 是集合的操作接口；
Collections 是集合操作的工具类，可以进行List、Set、Map集合的操作

JSP中两种包含的区别：
静态包含：<%@ include file=""%> 先包含在处理
动态包含：<jsp:include page=""/> 如果包含的是静态页面则先包含进来再一块处理，如果包含的是动态页面，则先处理后包含


JSP中的9中内置对象：
1、PageContext [javax.servlet.jsp.PageContext]	表示的是当前页面的上下文对象，可以设置属性以及取得其他8个内置对象
	取得request对象；public ServletRequest getRequest();
	取得response对象；public ServletResponse getResponse();
	取得application对象：public ServletContext getApplication();
		
2、request [javax.servlet.http.HttpServletRequest] 表示接收客户端的请求数据，可能是发送的数据或者是头信息
	取得单个数据：public String getParameter(String paramName);
	取得一组数据：public String[] getParameterValues(String paramName);
	取得所有的参数名称：public Enumeration getParameterNames();
	设置请求编码：public void setCharacterEncoding(String charSet) throws UnSupportedEncodingException;
	取得全部的Cookie：public Cookie[] getCookies();
	取得指定的头信息：public String getHeader(String headerName);
	取得所有的头信息名字：public Enumeration getHeaderNames();
	取得上下文路径：public String getContextPath();
	取得RequestDispatcher接口对象：public RequestDispatcher getRequestDispatcher();
	
3、response [javax.servlet.http.HttpServletResponse] 指的是服务器端回应客户端的请求数据
	设置头信息：public void setHeader(String name, String value);
	增加Cookie：public void addCookie(Cookie c);
	请求重定向：public void sendRedirect(String path);

4、session [javax.servlet.http.HttpSession] 描述每一个客户端的信息，session是Http协议范畴的产物，服务器端利用session和cookie的组合来区分不同的用户 ；
	让session失效：public void invalidate();
5、application [javax.servlet.ServletContext] 描述整个服务器的上下文对象，可以理解为表示服务器信息
	取得虚拟目录对应的真实路径：public void getRealPath(String url)
6、config [javax.servlet.ServletConfig] 取得相关的初始化配置信息，配置信息要在Web.xml文件中配置
	取得指定的初始化内容参数：public String getInitParamer(String paramName)
7、out [javax.servlet.jsp.JspWriter] 主要进行信息的输出使用，现在一般不使用，都使用表达式代替
8、page [java.lang.Object] 每一个页面都是一个类的对象
9、exception [java.lang.Throwable] JSP页面可以处理所有的异常，默认是由容器处理，处理的方式是输出异常信息并中断程序的执行，所以在JSP页面中的异常不用做明确处理




JSP中两种跳转的区别：
服务器端跳转：跳转之后地址栏不发生改变，可以传递request属性范围的内容，跳转后的语句内容不执行，语法<jsp: forward />
客户端跳转：跳转之后地址栏发生改变，是在一个页面全部执行完成后再进行跳转，不能够传递request属性范围的内容，
实现语法：超链接<a href=""></a>；JavaScript提供的window.location；设置refresh头信息进行定时跳转；response对象提供的sendRedirect()方法


session的整个操作过程中使用到了Cookie的处理机制；
当用户第一次访问的时候，服务器端会自动的为其分配一个session id ，并且将这个session id自动的保存在客户端的浏览器中，这样服务器就可以利用是否在请求头信息中出现过session id来判断是否是新用户；
每当用户发出请求后，那么会自动的将jsessionid发送到服务器上，服务器端会根据发送来的Cookie自动取得jsessionid的内容，并且与此内容与服务器上保存的jsessionid进行匹配，以确定不同的用户；

session的数据是保存在服务器端，而cookie的数据是保存在客户端的服务器中；
session使用了cookie的处理机制


Map<String, Integer> map = new HashMap<String, Integer>();
Set<Map.Entry<String, Integer>> set = map.entrySet();
Iterator<Map.Entry<String, Integer>> iter = set.iterator();
while(iter.hasNext()){
	Map.Entry<String, Integer> me = iter.next;
	System.out.println(me.getKey() + "=" + me.getValue());
}
