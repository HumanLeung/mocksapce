package com.example.mockspace.pdf.model;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import lombok.SneakyThrows;

import java.util.List;

/**
 * @author 梁晓明
 */
public class MyFooter implements IEventHandler {
    float fullwidth[] = {500f};
    protected Document doc;
    private List<String> tncList;
    private String imagePath;

    public MyFooter(Document doc, List<String> tncList, String imagePath) {
        this.doc = doc;
        this.tncList = tncList;
        this.imagePath = imagePath;
    }

    @SneakyThrows
    @Override
    public void handleEvent(Event currentEvent) {
        PdfDocumentEvent docEvent = (PdfDocumentEvent) currentEvent;
        PdfDocument pdfDocument = docEvent.getDocument();
        Document document = new Document(pdfDocument);

        float footerY = doc.getBottomMargin();
        Table tb = new Table(fullwidth);
        tb.addCell(new Cell().add(new Paragraph("TERMS AND CONDITIONS\n")).setBold().setBorder(Border.NO_BORDER));
        for (String tnc : tncList) {

            tb.addCell(new Cell().add(new Paragraph(tnc)).setBorder(Border.NO_BORDER));
        }
        tb.setFixedPosition(40f, footerY, 530f);
        this.doc.add(tb);

        ImageData imageData = ImageDataFactory.create(imagePath);
        Image image = new Image(imageData);
        float x = pdfDocument.getDefaultPageSize().getWidth() / 2;
        float y = pdfDocument.getDefaultPageSize().getHeight() / 2;
        image.setFixedPosition(x - 150, y - 170);
        image.setOpacity(0.1f);
        document.add(image);


    }
}


