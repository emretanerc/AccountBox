package com.etcmobileapps.ibanbankaccountanddigitalaccount.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.*
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.etcmobileapps.ibanbankaccountanddigitalaccount.R
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Iban
import com.google.android.material.snackbar.Snackbar


class BankAdapter(private val data: List<Iban>, val context: Context) : RecyclerView.Adapter<BankAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.bank_account_item, p0, false))
    }
    override fun getItemCount(): Int=data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvBankName?.text = data[position].bankName
        holder.tvIbanNumber?.text = data[position].ibanNumber
        holder.tvCurrency?.text = data[position].currency

        val popupMenu = PopupMenu(context, holder.popupBt)
        popupMenu.menu.add(Menu.NONE, 0, 0, R.string.item_copy);
        popupMenu.menu.add(Menu.NONE, 1, 1, R.string.item_delete);

        popupMenu.setOnMenuItemClickListener { menuItem -> //get id of the clicked item
            val id = menuItem.itemId

            //Get Values from R.string for Localization
            val bankNameLocalizationValue: String =  context.getString(R.string.bank_name)
            val ibanNumberLocalizationValue =          context.getString(R.string.iban_number)
            val currencyLocalizationValue =          context.getString(R.string.currency)
            val accountBoxAdValue =          context.getString(R.string.copy_ad)

            //Get Values from TextView
            val bankName = holder.tvBankName.text
            val ibanNumber = holder.tvIbanNumber.text
            val currency = holder.tvCurrency.text

            //Toast Message Localization
            val copiedValue =          context.getString(R.string.copied)
            //handle clicks
            if (id == 0) {
                val textToCopy =  "$bankNameLocalizationValue: $bankName \n$ibanNumberLocalizationValue: $ibanNumber \n$currencyLocalizationValue: $currency \n \n $accountBoxAdValue "
                val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clipData = ClipData.newPlainText("text", textToCopy)
                clipboardManager.setPrimaryClip(clipData)
                Snackbar.make(context,holder.itemView, copiedValue,Snackbar.LENGTH_LONG).show()
            }
            else if (id == 1) {

            }
            false
        }

        holder.popupBt.setOnClickListener(View.OnClickListener { popupMenu.show() })
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvBankName = itemView.findViewById<TextView>(R.id.bankName)
        val tvIbanNumber = itemView.findViewById<TextView>(R.id.ibanNumber)
        val tvCurrency = itemView.findViewById<TextView>(R.id.currency)
        val popupBt= itemView.findViewById<ImageButton>(R.id.popupBt)
    }
}