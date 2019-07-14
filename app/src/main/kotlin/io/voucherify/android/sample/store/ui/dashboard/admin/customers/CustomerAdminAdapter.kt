package io.voucherify.android.sample.store.ui.dashboard.admin.customers

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.utils.views.StickyAdapter

interface Section {

    enum class ViewType(val viewType: Int) {
        ITEM(0),
        HEADER(1)
    }

    fun type(): Int
    fun position(): Int
}

class CustomerAdminAdapter(private val itemClick: (item: CustomerResponse) -> Unit) :
    StickyAdapter<RecyclerView.ViewHolder, RecyclerView.ViewHolder>(), Filterable {

    private var items: List<Section> = emptyList()
    private var itemsSearchResult: List<Section> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            Section.ViewType.ITEM.viewType -> {
                CustomerAdminItemViewHolder(
                    layoutInflater.inflate(R.layout.item_customer_admin, parent, false)
                )
            }
            else -> {
                CustomerAdminItemHeaderViewHolder(
                    layoutInflater.inflate(R.layout.item_header_simple, parent, false)
                )
            }
        }
    }

    override fun getItemCount(): Int = itemsSearchResult.count()

    override fun getItemViewType(position: Int): Int {
        return itemsSearchResult[position].type()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val type = itemsSearchResult[position].type()

        when (type) {
            Section.ViewType.ITEM.viewType -> {
                val itemHolder = holder as CustomerAdminItemViewHolder
                val item = itemsSearchResult[position] as CustomerSectionItem
                itemHolder.item = item.customer

                itemHolder.view.setOnClickListener {
                    itemClick(item.customer)
                }
            }
            else -> {
                val headerHolder = holder as CustomerAdminItemHeaderViewHolder
                val header = itemsSearchResult[position] as CustomerHeaderSectionItem
                headerHolder.title = header.name
            }
        }

    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        return itemsSearchResult[itemPosition].position()
    }

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder, headerPosition: Int) {
        itemsSearchResult.find { it.position() == headerPosition }.let {
            val header = it as CustomerHeaderSectionItem
            (holder as CustomerAdminItemHeaderViewHolder).title = header.name
        }
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return createViewHolder(parent, Section.ViewType.HEADER.viewType)
    }

    fun setData(data: List<Section>) {
        items = data
        itemsSearchResult = data
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val charString = charSequence.toString()

                if (charString.isEmpty()) {
                    itemsSearchResult = items
                } else {
                    val filteredList = ArrayList<Section>()

                    val sectionItems = items.filterIsInstance(CustomerSectionItem::class.java)

                    for (row in sectionItems) {
                        if (row.customer.name?.startsWith(charString, ignoreCase = true) == true) {
                            filteredList.add(CustomerSectionItem(section = -1, customer = row.customer))
                        }
                    }

                    itemsSearchResult = filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = itemsSearchResult

                return filterResults
            }

            override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {
                itemsSearchResult = filterResults?.values as List<Section>
                notifyDataSetChanged()
            }
        }
    }
}

class CustomerSectionItem(
    private val section: Int,
    val customer: CustomerResponse
) : Section {

    override fun type(): Int = Section.ViewType.ITEM.viewType

    override fun position() = section
}

class CustomerHeaderSectionItem(
    private val section: Int,
    val name: String
) : Section {

    override fun type(): Int = Section.ViewType.HEADER.viewType

    override fun position(): Int = section
}