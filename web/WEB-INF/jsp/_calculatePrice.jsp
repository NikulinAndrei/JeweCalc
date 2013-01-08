<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="jewecalc.Calculator" %>
<%@ page import="jewecalc.quote.QuoteService" %>
<%@ page import="jewecalc.Material" %>
<%@ page import="jewecalc.Currency" %>

<%
    String material = request.getParameter("material") ;
    String unit = request.getParameter("unit");
    String probe = request.getParameter("probe");
    String weight = request.getParameter("weight");
    String currency = request.getParameter("currency");

    String calculatedPrice = Calculator.calculate( material, unit, weight, probe, currency);
%>
    <div class="alert">
        The calculated price for <strong><%=weight%> <%=unit%> </strong>
        of <strong><%=material%> ( probe <%=probe%>)</strong>
        is <strong><%=calculatedPrice%> <%=currency%></strong>
    </div>

