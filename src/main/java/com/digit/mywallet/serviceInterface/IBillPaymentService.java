package com.digit.mywallet.serviceInterface;

import com.digit.mywallet.entities.BillPayment;

public interface IBillPaymentService {

		BillPayment addBillPayment(BillPayment payment);

		BillPayment viewBillPayment(BillPayment payment);
}
