package kg.bishkoteka.ui.fragments.main.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kg.bishkoteka.ui.fragments.main.organization.create_organization.OrganizationCreateFragment
import kg.bishkoteka.ui.fragments.main.organization.my_organizations.MyOrganizationsFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity, private var totalCount: Int) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MyOrganizationsFragment()
            1 -> OrganizationCreateFragment()
            else -> MyOrganizationsFragment()
        }
    }
}
