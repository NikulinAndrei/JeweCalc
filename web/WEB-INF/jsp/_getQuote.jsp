<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="jewecalc.quote.QuoteService" %>
<%@ page import="jewecalc.Material" %>
<%@ page import="jewecalc.Currency" %>
<%@ page import="jewecalc.Unit" %>
<%
    String material = request.getParameter("material") ;
    String unit = request.getParameter("unit");
    String currency = request.getParameter("currency");

    String pricePerUnit = String.valueOf( new QuoteService().
            getPrice( Material.valueOf(material)).
            toCurrency( Currency.valueOf(currency)).
            toUnit( Unit.valueOf(unit)).
            toDouble());
    out.print(pricePerUnit);
%>