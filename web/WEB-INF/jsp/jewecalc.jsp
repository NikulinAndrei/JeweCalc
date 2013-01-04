<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="jewecalc.CalculatorHelper" %>
<%@ page import="jewecalc.PacketizerQuoteService" %>
<%@ page import="jewecalc.Material" %>
<%@ page import="jewecalc.Currency" %>
<%
    String pricePerUnit = "..." ;
    String calculatedPrice = null;
    String material = request.getParameter("material") ;
    String unit = request.getParameter("unit");
    String probe = request.getParameter("probe");
    String weight = request.getParameter("weight");
    String currency = request.getParameter("currency");
    String submit = request.getParameter("submit");

    if(submit != null){
        calculatedPrice = CalculatorHelper.calculate( material, unit, weight, probe, currency);
        pricePerUnit = String.valueOf( new PacketizerQuoteService().
          getPrice( Material.valueOf(material)).
          toCurrency( Currency.valueOf(currency)).
          toDouble());
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Jewelery calculator</title>
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <form class="form-horizontal" method="post">
            <legend>Provide your jewelery data</legend>

            <div class="control-group">
                <label class="control-label" for="material">Metal</label>
                <div class="controls">
                    <select name="material" id="material">
                        <option value="GOLD" <%if("GOLD".equals(material)){out.print("selected");} %> >Gold</option>
                        <option value="SILVER" <%if("SILVER".equals(material)){out.print("selected");} %> >Silver</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="unit">Weight unit</label>
                <div class="controls">
                    <select name="unit" id="unit">
                        <option value="g" <%if("g".equals(unit)){out.print("selected");} %> >Grams</option>
                        <option value="oz" <%if("oz".equals(unit)){out.print("selected");} %> >OZ</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="currency">Currency</label>
                <div class="controls">
                    <select name="currency" id="currency">
                        <option value="USD" <%if("USD".equals(unit)){out.print("selected");} %> >USD</option>
                        <option value="EUR" <%if("EUR".equals(unit)){out.print("selected");} %> >EUR</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="price">Stock price</label>
                <div class="controls">
                    <input type="text" name="price" id="price" readonly="readonly" value="<%= pricePerUnit == null? "" : pricePerUnit%>"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="probe">Probe</label>
                <div class="controls">
                    <input type="text" name="probe" id="probe" value="<%= probe == null? "" : probe%>"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="weight">Weight</label>
                <div class="controls">
                    <input type="text" name="weight" id="weight" value="<%= weight == null? "" : weight%>" />
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <input type="submit" class="btn btn-primary" name="submit" value="Calculate"></input>
                </div>
            </div>

            <% if(calculatedPrice!=null){ %>
            <div class="control-group">
                <div class="alert">
                    The calculated price is <strong><%=calculatedPrice%> USD</strong>
                </div>
            </div>
            <%}%>

        </form>
    </div>
</body>
</html>