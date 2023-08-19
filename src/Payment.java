static public class payment
    {
        private int paymentID;

        payment(int paymentID)
        {

            this.paymentID = paymentID;

        }

        int getPaymentID()
        {
            return paymentID;


        }

        public void setPaymentID(int paymentID) {
            this.paymentID = paymentID;
        }

        void automate()
        {


        }

        void print()
        {
            System.out.println("Payment ID NO: " + paymentID);

        }


    }
