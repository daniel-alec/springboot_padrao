package com.example.padrao.domain;

import com.example.padrao.model.Estacao;
import org.springframework.data.domain.Page;

public class DataTableResultInfo {

    private Page<Estacao> data;
    private int draw; //the NO.of requests
    private int length;
    private long recordsTotal;
    private long recordsFiltered;

    public DataTableResultInfo() {
    }

    public DataTableResultInfo(Page<Estacao> data, int draw, int length, long recordsTotal, long recordsFiltered) {
        this.data = data;
        this.draw = draw;
        this.length = length;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Page<Estacao> getData() {
        return data;
    }

    public void setData(Page<Estacao> data) {
        this.data = data;
    }
}
