<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="com.digit.mywallet.entities.Customer"%>
<%@ page import="com.digit.mywallet.entities.Wallet" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wallet Home</title>

 <style>
 body{
 
/*  background-color:#8ca3b4; */
 margin:0;
 padding:0;
 background-image: url('/homeBg.jpg');
 
     background-repeat:no-repeat ; 
    background-size:cover;
        }
 
        table {
  border: 0px solid black;
    border-collapse: collapse;
    width: 100%;
    padding-left: 44px;
    margin-left: 13px;
}
th{
    height: 100px;
}
.rightbuttons{
    align-content: end;
}
#mywallet{
    color: #612b5f;
    background-color: #a7f0b9;
    padding: 10px;
    text-align: center;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
#logout{
align-items: center;
 border-radius:12px;

}
button{
   border-radius:12px;
    color: #10021d;
    font-weight: bold;
    padding: 15px;
    font-size: medium;
    font-family: sans-serif;
    background-color:#a8d2a0 ;
}
.vertical-center{
margin: 0;
  position: absolute;
  top: 50%;
  -ms-transform: translateY(-50%);
  transform: translateY(-50%);
}
.logout{
align-items: center;
 border-radius:12px;

}
.design{
background-color: #689ff1;
    border-radius: 13px;
    padding: 17px;
    color: black;
    


}
    </style>
</head>
<body >
      <%
       Customer customer = (Customer)session.getAttribute("customer");
       Wallet wallet = customer.getWallet();
      %> 
    <h1 id="mywallet">MY WALLET </h1>
    <div></div>
    <table >
        <tr><th><a href="/transfer.jsp"><button>Fund Transfer</button></a></th>
        
        
       
            <th colspan="2" rowspan="2"><div><h1 class="design">Name: ${customer.getName()}</h1> </div></th>
            <th><a href="/viewAll/${wallet.getWalletId()}"><button>Bank Accounts</button></a></th>
        </tr>
          <tr>  <th><a href="/add-amount.jsp"><button>Add Amount</button></a></th>
            <th><a href="/viewTransactionsByWalletId/${wallet.getWalletId()}"><button>Transactions</button></a></th>
        </tr>
        <tr><th><a href="/viewallbills"><button>Bill Payments</button></a></th>
        
       
            <th colspan="2" rowspan="2"><div><h1 class="design" >Amount : ${wallet.getAmount()}</h1> </div></th>
            <th><a href="/update1"><button>Update Account</button></a></th></tr>

        <tr>
            <th><a href="/deposit.jsp"><button>Deposit Amount</button></a></th>
            <th><a href="/viewall"><button>Beneficiaries </button></a></th>
        </tr>

        

    </table>
    
    <div style="text-align: center;">
    <a href="/logout" class="logout" ><button style="background: #163561;
    width: 154px;
    color: white;">Logout</button></a>
  </div>
    

    
</body>
</html>


 
