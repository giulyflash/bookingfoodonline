<jsp:include page="/Box/header.jsp"/>
        
    <div id="page">
    <div id="page-bgtop">
      <div id="content">
          <jsp:include page="/Pages/formRegister.jsp" />
          <tr>
                            <td>Invia:</td>
                            <%if(request.getSession().getAttribute("reg").equals("reg1")){%>
                                <td><input type="submit" value="Invia" name="Register" /></td>
                                <%}else{%>
                                    <td><input type="submit" value="Registrati" name="Register" /></td>
                                <%}%>
                                <%request.getSession().removeAttribute("reg");%>
                        </tr>
                    </tbody>
                </table>
            </form>
          </div>
        </div>

      </div>
      </div>
      <!-- end div#content -->
      <div id="sidebar">
        <jsp:include page="/Box/Sidebar.jsp" />
      </div>
      <!-- end div#sidebar -->
      <div style="clear: both; height: 1px"></div>
    </div>
  </div>  <!-- end div#page -->
</div>
<!-- end div#wrapper -->
</body>
</html>