package com.marcelsistemapedidos;

public class Exec1 {

    // Abaixo já é a classe refatorada no que eu achei que deveria ser...


    /* Pontos: Uso Incorreto do Logger, constantes Não Utilizadas, try-catch vazio, método isNotValid de difícil compreensão,
     uso de strings literais ("01", "02", "10"), estrutura de condicionais profundamente aninhadas, método salvar com parâmetro desnecessário

    class TransactionValidator {

        private static final Logger LOGGER = LoggerFactory.getLogger(TransactionValidator.class);

        private static final String CODE_01 = "01";
        private static final String CODE_02 = "02";
        private static final String CODE_10 = "10";

        private static final List<String> VALID_CODES = List.of("02", "03", "04", "05", "12");

        public void validate(ISOModel isoModel) {
            LOGGER.info("Validation started.");

            boolean isBit02Null = isoModel.getBit02() == null;
            boolean isBit02Empty = isoModel.getBit02() != null && isoModel.getBit02().getValue().isEmpty();
            boolean isAuxValidation = isBit02Empty && isoModel.getBit03() == null;
            String codeValue = isBit02Null ? CODE_01 : CODE_02;

            if (isInvalid(isBit02Null, isBit02Empty, isAuxValidation, codeValue)) {
                throw new IllegalArgumentException("Required values are missing.");
            }

            if (isoModel.getBit03() == null) {
                throw new IllegalArgumentException("Bit03 is required.");
            }

            if (isoModel.getBit04() == null || !VALID_CODES.contains(isoModel.getBit04().getValue())) {
                throw new IllegalArgumentException("Invalid or missing Bit04.");
            }

            if (isoModel.getBit05() == null) {
                throw new IllegalArgumentException("Bit05 is required.");
            }

            if (isoModel.getBit12() == null) {
                throw new IllegalArgumentException("Bit12 is required.");
            }

            saveTransaction(isoModel, isAuxValidation);
        }

        private boolean isInvalid(boolean isBit02Null, boolean isBit02Empty, boolean isAuxValidation, String codeValue) {
            return isBit02Null || (isBit02Empty && !isAuxValidation && codeValue.equals(CODE_01));
        }

        private void saveTransaction(ISOModel isoModel, boolean isAuxValidation) {
            if (isAuxValidation) {
                throw new IllegalArgumentException("Validation failed.");
            }

            System.out.println("Saving transaction " + isoModel.getBit02().getValue());
        }

    }*/


}
