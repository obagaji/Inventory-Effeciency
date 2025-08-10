package com.jtc.Inventory.Effeciency.supplierInvent;

import com.jtc.Inventory.Effeciency.inventDto.SalesDetails;

import java.util.function.Supplier;

public class SalesdetailSupplier implements Supplier<SalesDetails> {
    @Override
    public SalesDetails get() {
        return new SalesDetails(00,00.00,00.00,"No  Sales Agent Available ");
    }
}
