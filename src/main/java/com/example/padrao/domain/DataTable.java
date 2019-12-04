package com.example.padrao.domain;

import com.example.padrao.model.Estacao;
import org.springframework.data.domain.Page;

import java.util.List;

public class DataTable {

    private List<Estacao> data;
    private int start;
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;

    public DataTable() {
    }

    public DataTable(List<Estacao> data, int start, int draw, long recordsTotal, long recordsFiltered) {
        this.data = data;
        this.start = start;
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
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

    public List<Estacao> getData() {
        return data;
    }

    public void setData(List<Estacao> data) {
        this.data = data;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
