package com.example.try1;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int READ_REQUEST_CODE = 42;

    private Button btnSelectPdf;
    private TextView txtPdfContents;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelectPdf = findViewById(R.id.btn_select_pdf);
        txtPdfContents = findViewById(R.id.txt_pdf_contents);

        btnSelectPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPdf();
            }
        });
    }

    private void selectPdf() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");

        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            readPdf(uri);
        }
    }

    private void readPdf(Uri uri) {
        try {
            // get a PDF reader
            PdfReader reader = new PdfReader(getContentResolver().openInputStream(uri));

            // get the number of pages in the PDF
            int numPages = reader.getNumberOfPages();

            // initialize a string builder to store the contents of the PDF
            StringBuilder pdfContents = new StringBuilder();

            // extract the text from each page of the PDF and append it to the string builder
            for (int i = 1; i <= numPages; i++) {
                pdfContents.append(PdfTextExtractor.getTextFromPage(reader, i));
            }
String strr=pdfContents.toString();
            // close the PDF reader
            reader.close();
            String strNew=strr.replace("No of","");
            strr=strNew.replace("*********** End of statement *********","");

            // set the contents of the PDF to the text view
            txtPdfContents.setText(strr);
        } catch (IOException e) {
            Log.e(TAG, "Error reading PDF file", e);
        }
    }
}
