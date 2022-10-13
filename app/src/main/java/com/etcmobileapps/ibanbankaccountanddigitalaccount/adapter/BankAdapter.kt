package com.etcmobileapps.ibanbankaccountanddigitalaccount.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.etcmobileapps.ibanbankaccountanddigitalaccount.R
import com.etcmobileapps.ibanbankaccountanddigitalaccount.model.Iban



class BankAdapter(private val data: List<Iban>, val context: Context) : RecyclerView.Adapter<BankAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.bank_account_item, p0, false))
    }
    override fun getItemCount(): Int=data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvBankName?.text = data[position].bankName
        holder.tvIbanNumber?.text = data[position].ibanNumber
        holder.tvCurrency?.text = data[position].currency
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvBankName = itemView.findViewById<TextView>(R.id.bankName)
        val tvIbanNumber = itemView.findViewById<TextView>(R.id.ibanNumber)
        val tvCurrency = itemView.findViewById<TextView>(R.id.currency)

    }
}