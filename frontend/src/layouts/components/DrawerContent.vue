<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '작가 관리' }" />
        <VerticalNavLink
            :item="{
                title: '작가',
                to: '/authors',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '구독자 관리' }" />
        <VerticalNavLink
            :item="{
                title: '구독자',
                to: '/subscribers',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독',
                to: '/subscribes',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독 열람',
                to: '/subscribeViews',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '집필 관리' }" />
        <VerticalNavLink
            :item="{
                title: '집필',
                to: '/writings',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '포인트 관리' }" />
        <VerticalNavLink
            :item="{
                title: '포인트',
                to: '/포인트',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '평점 관리' }" />
        <VerticalNavLink
            :item="{
                title: '책서비스',
                to: '/bookServices',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'AI/시스템' }" />
        <VerticalNavLink
            :item="{
                title: 'AI',
                to: '/ais',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '책 관리' }" />
        <VerticalNavLink
            :item="{
                title: '책',
                to: '/books',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Dashboard' }" />
        <VerticalNavLink
            :item="{
                title: 'mypage',
                to: '/mypages',
            }"
        />
    </ul>
</template>
