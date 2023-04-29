package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.StringUtils;

public class PassportCardNumber {

        // ATTRIBUTES

        private int passportCardNumber;
        private final int PASSPORT_CARD_NUMBER_BY_DEFAULT = 00000000;

        private static final int PASSPORT_NUMBER_LENGTH = 8;

        // CONSTRUCTORS

        /**
         * This method creates the PassportCardNumber object with default attributes
         */
        public PassportCardNumber() {
            this.passportCardNumber = PASSPORT_CARD_NUMBER_BY_DEFAULT;
        }

        /**
         * This method creates the PassportCardNumber object
         *
         * @param passportCardNumber
         */
        public PassportCardNumber(int passportCardNumber) {
            this.passportCardNumber = passportCardNumber;
        }

        // SETS AND GETS

        /**
         * This method returns the passportNumber of the PassportCard
         *
         * @return
         */
        public int getPassportCardNumber() {
            return passportCardNumber;
        }

        /**
         * This method changes the passportNumber of the PassportCard
         *
         * @param passportCardNumber
         */
        public void setPassportCardNumber(int passportCardNumber) {
            this.passportCardNumber = passportCardNumber;
        }

        // TO STRING

        /**
         * This method returns the characteristics of the PassportCard
         *
         * @return
         */
        @Override
        public String toString() {
            return " | Passport Card Number: " + passportCardNumber;
        }
}