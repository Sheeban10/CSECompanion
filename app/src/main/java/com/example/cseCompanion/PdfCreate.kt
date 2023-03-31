package com.example.cseCompanion

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_mst_marks.*
import java.io.FileOutputStream
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class PdfCreate : AppCompatActivity() {

   // private val STORAGE_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_mst_marks)

        /*create_pdf_mst.setOnClickListener {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED
                ){
                    val permission = arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(permission,STORAGE_CODE)
                }else{
                    savePDF()
                }
            }else{
                savePDF()
            }
        }*/


    }

    /*private fun savePDF() {
        val mDoc = Document()
        val mFileName = SimpleDateFormat("yyMMdd_HHmmss", Locale.getDefault())
            .format(System.currentTimeMillis())

        val mFilePath = Environment.getExternalStorageDirectory().toString() + "/" + mFileName + ".pdf"

        try {

            PdfWriter.getInstance(mDoc , FileOutputStream(mFilePath))
            mDoc.open()

            mDoc.addAuthor("CSE Companion BBSBEC")
            mDoc.add(Paragraph(cc_marks.text.toString()))
            Toast.makeText(this, "$mFileName.pdf\n is create to \n$mFilePath", Toast.LENGTH_SHORT).show()

        }catch (e: Exception){
            Toast.makeText(this,e.message , Toast.LENGTH_SHORT).show()
        }
    }*/

    /*override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            STORAGE_CODE -> {
                if ( grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    savePDF()
                }else{
                    Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
*/

}
